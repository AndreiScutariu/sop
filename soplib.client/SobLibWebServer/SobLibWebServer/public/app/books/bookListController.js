(function (module, $) {

	module.controller("bookListController", ["$scope", "$filter", "bookService", "pubSub", function ($scope, $filter, bookService, pubSub) {

			$scope.delete = function(book) {
				console.log(book.links);
			};

			var refreshBooksGrid = function() {
				var callback = function(response) {
					$scope.books = response.data;
				};
				bookService.getAll(callback);
			};

			refreshBooksGrid();
			pubSub.subscribe("refreshBooksGrid", refreshBooksGrid);
		}]);

})(angular.module('app'), jQuery);
