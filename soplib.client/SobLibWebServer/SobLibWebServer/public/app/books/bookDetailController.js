(function (module, $) {

	var callback = function(response) {
		console.log(response);
	};

	module.controller("bookDetailController", ["$scope", "$filter", "bookService", "pubSub", function ($scope, $filter, bookService, pubSub) {
			$scope.book = {};
			$scope.modalShown = false;
			$scope.labels = { frmTitle: "Add new Book", btnName: "Publish" };

			$scope.addNewBook = function() {
				$scope.modalShown = true;
			};

			$scope.saveBook = function() {
				bookService.publish($scope.book);
			};
		}]);

})(angular.module('app'), jQuery);
