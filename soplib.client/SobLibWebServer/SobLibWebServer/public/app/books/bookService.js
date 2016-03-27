(function (module) {

    function errorCallback(response) {
        console.log(response);
    };

    module.service('bookService', ["$http", "configurationService", function ($http, configurationService) {

            this.getAll = function (callback) {
                $http.get(configurationService.books.base).then(callback, errorCallback);
            };

            this.publish = function(book, callback) {
                var config = {
                    method: 'POST',
                    url: configurationService.books.publish,
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': 'Basic ' + '1e9e87f75bf049a699b8a32b41fda1b00061fd5a0bd14ea4b19b6053f9bc372b95461aa64a2d40d48926595fb25e6fe7'
                     },
                    data: book
                };
                $http(config).then(callback, errorCallback);
            };

        }]);

})(angular.module('app'));
