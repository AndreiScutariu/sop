(function (module) {

    module.factory('generateTokenFactory', ["$http", "configurationService", function ($http, configurationService) {
            var obj = {};

            function successCallback(response) {
                sessionStorage.token = response.data.token;
            };

            function errorCallback(response) {
                console.log(response);
            };

            obj.generateToken = function(requestObj) {
                var config = {
                    method: 'POST',
                    url: configurationService.tockenProviderEndpoint,
                    headers: {
                        'Content-Type': 'application/json'
                     },
                    data: requestObj
                };
                $http(config).then(successCallback, errorCallback);
            };

            obj.getToken = function() {
                console.log("Current token: " + sessionStorage.token);
                return sessionStorage.token;
            };

            return obj;
        }]);

})(angular.module('app'));
