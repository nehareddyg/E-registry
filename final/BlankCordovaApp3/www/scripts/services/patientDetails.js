app.service('patient', function ($http) {
    this.getDetails = function (patientId) {
        return $http.get('http://localhost:8082/EpilepsyServer/rest/Patient/' + patientId)
    };
});