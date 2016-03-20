(function (module) {
	
	module.directive('loading', ["$http", function ($http) {
			return {
				restrict: 'A',
				link: function (scope, elm, attrs) {
					scope.isLoading = function () {
						return $http.pendingRequests.length > 0;
					};
					
					scope.$watch(scope.isLoading, function (v) {
						if (v) {
							console.log("show");
							elm.show();
						} else {
							console.log("hide");
							elm.hide();
						}
					});
				}
			};
		}]);

})(angular.module('app'));