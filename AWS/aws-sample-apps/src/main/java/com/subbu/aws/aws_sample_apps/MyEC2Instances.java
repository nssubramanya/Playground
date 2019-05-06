package com.subbu.aws.aws_sample_apps;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.AvailabilityZone;
import com.amazonaws.services.ec2.model.DescribeAvailabilityZonesResult;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.DescribeRegionsResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;

public class MyEC2Instances {
	
	public static void main (String [] args) {
		AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();
		DescribeRegionsResult regionsResult = ec2.describeRegions();
		DescribeInstancesRequest request = new DescribeInstancesRequest();
		DescribeInstancesResult response = null;
		
		for (com.amazonaws.services.ec2.model.Region region : regionsResult.getRegions()) {
			System.out.printf("Region: %s (%s)\n", region.getRegionName(), region.getEndpoint());
			
			ec2 = AmazonEC2ClientBuilder.standard().withRegion(region.getRegionName()).build();
			
			boolean done = false;
			
			while(!done) {
			    response = ec2.describeInstances(request);

			    for(Reservation reservation : response.getReservations()) {
			        for(Instance instance : reservation.getInstances()) {
			            System.out.printf(
			                "Found instance with id %s, " +
			                "AMI %s, " +
			                "type %s, " +
			                "state %s " +
			                "and monitoring state %s",
			                instance.getInstanceId(),
			                instance.getImageId(),
			                instance.getInstanceType(),
			                instance.getState().getName(),
			                instance.getMonitoring().getState());
			        }
			    }

			    request.setNextToken(response.getNextToken());

			    if(response.getNextToken() == null) {
			        done = true;
			    }
			}

			System.out.println("=========================================\n");
		}
	}
}
