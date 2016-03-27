(function (module, $) {
	var callback = function(response) {
		console.log(response);
	};

	module.controller("bookListController", ["$scope", "$filter", "bookService", "pubSub", function ($scope, $filter, bookService, pubSub) {
			bookService.getAll(callback);
		}]);

})(angular.module('app'), jQuery);
