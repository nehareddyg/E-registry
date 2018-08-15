app3.service('getCaseForm', function ($http) {
    this.getDetails = function (patId) {
        return $http.get('http://localhost:8082/EpilepsyServer/rest/NewEncounter/' + patId);
    };

    this.getFile = function (patId) {
        return $http.get('http://localhost:8082/EpilepsyServer/rest/NewEncounter/download/' + patId, { responseType: 'arraybuffer'});
    };
});