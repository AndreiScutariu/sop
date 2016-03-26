(function (module) {

    function errorCallback(response) {
        console.log(response);
    };

    module.service('userService', ["$http", "$filter", "configurationService", function ($http, $filter, configurationService) {

            this.getAll = function (callback) {
                $http.get(configurationService.usersEndpoint).then(callback);
            };

            this.getUser = function (user, callback) {
                var uri = $filter('filter')(user.links, {desc: "self"})[0];
                var u = configurationService.buildEndpoint(uri.href);
                $http.get(u).then(callback, errorCallback);
            };

            this.deleteUser = function (user, callback) {
                var uri = $filter('filter')(user.links, {desc: "self"})[0];
                var u = configurationService.buildEndpoint(uri.href);
                $http.delete(u).then(callback, errorCallback);
            };

            this.save = function (user, callback) {
                $http.post(configurationService.usersEndpoint, user).then(callback, errorCallback);
            };

        }]);

})(angular.module('app'));
