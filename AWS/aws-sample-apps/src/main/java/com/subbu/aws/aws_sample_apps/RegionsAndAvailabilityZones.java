package com.subbu.aws.aws_sample_apps;

import java.util.List;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.RegionUtils;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.AvailabilityZone;
import com.amazonaws.services.ec2.model.DescribeAvailabilityZonesResult;
import com.amazonaws.services.ec2.model.DescribeRegionsResult;

public class RegionsAndAvailabilityZones {

	public static void showRegionsUsingEnum() {
		System.out.println("List of Regions using `Regions` enum:");
		for (Regions regions : Regions.values()) {
			System.out.println(regions);
		}
	}

	public static void showRegionsUsingRegionUtils() {
		// Region List in Another way
		System.out.println("List of Regions using RegionUtils:");
		List<Region> regionList = RegionUtils.getRegions();
		for (Region region : regionList) {
			System.out.println(region);
		}
	}

	public static void showAllRegionsAndAZs() {
		AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();
		DescribeRegionsResult regionsResult = ec2.describeRegions();

		for (com.amazonaws.services.ec2.model.Region region : regionsResult.getRegions()) {
			System.out.printf("Region: %s (%s)\n", region.getRegionName(), region.getEndpoint());
			
			ec2 = AmazonEC2ClientBuilder.standard().withRegion(region.getRegionName()).build();

			System.out.println("Availability Zones:");
			DescribeAvailabilityZonesResult azResult = ec2.describeAvailabilityZones();
			for (AvailabilityZone az : azResult.getAvailabilityZones()) {
				System.out.printf("%s - %s - %s - %s\n", az.getZoneId(), az.getZoneName(), az.getRegionName(),
						az.getState());
			}
			System.out.println("=========================================\n");
		}
	}


	public static void main(String[] args) {
		showAllRegionsAndAZs();	
	}
}
