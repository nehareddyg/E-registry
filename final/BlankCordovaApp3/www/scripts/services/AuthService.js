app1.factory('AuthService', function ($http, Session) {
    var authService = {};
    console.log("pp");
    authService.login = function (credentials) {
        return $http
          .get("http://localhost:8082/EpilepsyServer/rest/Practitioner/login/" + "?username=" + credentials.username + "&password=" + credentials.passwd + "&role=" + credentials.practitioner)
          .then(function (res) {
              console.log(res.data.practitioner.id);
              Session.create(res.data.practitioner.id, res.data.practitioner.name,res.data.practitioner.username,
                             res.data.practitioner.role);
              return res.data.practitioner;
          });
    };
    
    authService.isAuthenticated = function () {
        return !!Session.userId;
    };

    authService.isAuthorized = function (authorizedRoles) {
        if (!angular.isArray(authorizedRoles)) {
            authorizedRoles = [authorizedRoles];
        }
        return (authService.isAuthenticated() &&
          authorizedRoles.indexOf(Session.userRole) !== -1);
    };
    
    return authService;
})