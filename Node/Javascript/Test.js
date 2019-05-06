/*jshint esversion:6 */
(function () {
    "use strict";

    var machine = {
        isOn: false,
        start: function () {
            this.isOn = true;
            console.log('Machine is starting...');
            setTimeout(() => {
                console.log("Started");
                console.log(machine.isOn);
            }, 2000);
        }
    };

    console.log(machine.isOn);
    machine.start();

}());