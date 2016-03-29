(function (module) {

    function errorCallback(response) {
        console.log(response);
    };

    module.service('bookService', ["$http", "configurationService", "generateTokenFactory", function ($http, configurationService, tokenFactory) {

            this.getAll = function (callback) {
                $http.get(configurationService.books.base).then(callback, errorCallback);
            };

            this.publish = function(book, callback) {
                var config = {
                    method: 'POST',
                    url: configurationService.books.publish,
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': 'Basic ' + tokenFactory.getToken()
                     },
                    data: book
                };
                console.log(config);
                $http(config).then(callback, errorCallback);
            };

        }]);

})(angular.module('app'));
