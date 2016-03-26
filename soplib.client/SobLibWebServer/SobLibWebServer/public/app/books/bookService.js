(function (module) {

    function errorCallback(response) {
        console.log(response);
    };

    module.service('bookService', ["$http", "configurationService", function ($http, configurationService) {

            this.getAll = function (callback) {
                $http.get(configurationService.books.base).then(callback, errorCallback);
            };

        }]);

})(angular.module('app'));
