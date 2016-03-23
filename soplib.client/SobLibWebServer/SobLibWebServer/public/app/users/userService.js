(function (module) {
    
    module.service('userService', ["$http", "configurationService", function ($http, configurationService) {
            this.getAll = function (callback) {
                $http.get(configurationService.usersEndpoint).then(callback);
            };
            this.save = function (user, callback) {
                $http.post(configurationService.usersEndpoint, user).then(callback);
            };
        }]);

})(angular.module('app'));