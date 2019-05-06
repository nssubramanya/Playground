(function () {
    "use strict";

    try {
        console.log(p);
    } catch (err) {
        console.log(err.message);
    } finally {
        console.log('Finally');
    }
})();