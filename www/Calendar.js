"use strict";
function Calendar() {
}

Calendar.prototype.initializeBeacon = function (successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, "Calendar", "initializeBeacon", [{
  }])
};

Calendar.install = function () {
  if (!window.plugins) {
    window.plugins = {};
  }

  window.plugins.calendar = new Calendar();
  return window.plugins.calendar;
};

cordova.addConstructor(Calendar.install);
