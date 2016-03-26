(function (module) {

    function errorCallback(response) {
        console.log(response);
    };

    var req = {
 method: 'POST',
 url: 'http://example.com',
 headers: {
   'Content-Type': undefined
 },
 data: { test: 'test' }
    };

    module.service('bookService', ["$http", "configurationService", function ($http, configurationService) {

            this.getAll = function (callback) {
                $http.get(configurationService.books.base).then(callback, errorCallback);
            };

        }]);

})(angular.module('app'));
