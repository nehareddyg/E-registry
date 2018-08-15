app2.service('patientRegistry', function ($http) {
    this.create = function (patientData) {
        return $http.post("http://localhost:8082/EpilepsyServer/rest/Patient/create/" + "?name=" + patientData.name + "&age=" + patientData.age + "&sex=" + patientData.sex + "&siNo=" + patientData.siNo + "&fatherName=" + patientData.fatherName + "&village=" + patientData.village)
    }
});