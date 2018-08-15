app3.service('createCaseForm', function ($http) {
    this.update = function (data) {
        var string = "";
        for (var i = 0; i < data.length; i++) {
            if (i == data.length - 1) { string = string + data[i]; }
            else { string = string + data[i] + "-"; }
        }
        return string;
    };
    String.prototype.replaceAll = function (s, r) { return this.split(s).join(r) };

    this.createUrl = function (data, arrpf, arrfh, patId, pracId) {
        var preFactors = this.update(arrpf);
        var familyHistory = this.update(arrfh);
        var url = "http://localhost:8082/EpilepsyServer/rest/NewEncounter/create/" +
            "?patientId=" + patId +
                "&practitionerId=" + pracId +
                "&location=" + data.location +
                "&date=" + "2016-05-31" +
                "&ageAtOnset=" + data.ageAtOnset.name.replaceAll(" ", "%20") +
                "&typeOfSeizures=" + data.typeOfSeizures.name.replaceAll(" ", "%20") +
                "&subtypeOfSeizures=" + data.subTypeOfSeizures.name.replaceAll(" ", "%20") +
                "&durationOfSeizures=" + data.durationOfSeizures.name.replaceAll(" ", "%20") +
                "&focBeforeTreatment=" + data.focBeforeTreatment.name.replaceAll(" ", "%20") +
                "&focWithTreatment=" + data.focWithTreatment.name.replaceAll(" ", "%20") +
                "&clusterAttacks=" + data.clusterAttacks.name.replaceAll(" ", "%20") +
                "&statusEpilepticus=" + data.statusEpilepticus.name.replaceAll(" ", "%20") +
                "&precipitatingFactors=" + preFactors.replaceAll(" ", "%20") +
                "&pastHistory=" + data.pastHistory.name.replaceAll(" ", "%20") +
                "&familyHistory=" + familyHistory.replaceAll(" ", "%20") +
                "&probableAF=" + data.probableAF.name.replaceAll(" ", "%20") +
                "&pms=" + data.pms.name.replaceAll(" ", "%20") +
                "&desOfClinicalSeizures=" + data.desOfClinicalSeizures.replaceAll(" ", "%20") +
                "&prevTreatment=" + data.prevTreatment.name.replaceAll(" ", "%20") +
                "&gi=" + data.gi.name.replaceAll(" ", "%20") +
                "&ne=" + data.ne.name.replaceAll(" ", "%20") +
                "&treatmentAdvised=" + data.treatmentAdvised.replaceAll(" ", "%20") +
                "&mtest=" + "lopo";
        url = url.replaceAll("<", "%3C");
        url = url.replaceAll(">", "%3E");
        url = url.replaceAll(" ", "%20");
        console.log(url);
        return url;
    };

    this.create = function (data, arrpf, arrfh, patId, pracId) {
        var url = this.createUrl(data, arrpf, arrfh, patId, pracId);
        return $http.post(url);
    }

    this.uploadFileToUrl = function (file, patientId) {
        var fd = new FormData();
        fd.append('myFile', file);
        $http.post("http://localhost:8082/EpilepsyServer/rest/NewEncounter/create/file?patientId=" + patientId, fd, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).success(function () { }).error(function (error) { console.log(error); });
    };
});