(function (module, $) {

	module.controller("bookDetailController", ["$scope", "$filter", "bookService", "pubSub", function ($scope, $filter, bookService, pubSub) {
			$scope.book = {};
			$scope.modalShown = false;
			$scope.labels = { frmTitle: "Add new Book", btnName: "Publish" };

			$scope.addNewBook = function() {
				$scope.modalShown = true;
			};

			var callback = function(response) {
				$scope.modalShown = false;
				pubSub.publish("refreshBooksGrid");
			};

			$scope.saveBook = function() {
				bookService.publish($scope.book, callback);
			};
		}]);

})(angular.module('app'), jQuery);
