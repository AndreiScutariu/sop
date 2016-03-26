(function (module, $) {

	module.controller("bookDetailController", ["$scope", "$filter", "bookService", "pubSub", function ($scope, $filter, bookService, pubSub) {
			$scope.book = {};
			$scope.modalShown = false;
			$scope.labels = { frmTitle: "Add new Book", btnName: "Publish" };

			$scope.addNewBook = function() {
				$scope.modalShown = true;
			};
		}]);

})(angular.module('app'), jQuery);
