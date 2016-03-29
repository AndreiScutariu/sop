(function (module, $) {

	module.controller("generateTokenController", ["$scope", "$filter", "generateTokenFactory", "pubSub", function ($scope, $filter, tokenFactory, pubSub) {

			$scope.request = {};

			$scope.generateToken = function() {
                tokenFactory.generateToken($scope.request);
            };
		}]);

})(angular.module('app'), jQuery);
