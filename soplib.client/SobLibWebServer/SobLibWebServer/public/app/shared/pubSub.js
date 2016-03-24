(function ($, module) {

    module.factory('pubSub', [function () {
            var o = $({});

            return {
                publish: function() {
                    o.trigger.apply(o, arguments);
                },
                subscribe: function(eventName) {
                    o.on.call(o, eventName, arguments[1]);
                }
            };
        }]);

})(jQuery, angular.module('app'));
