app4.service('createFolUp', function ($http) {
    this.create = function (patientData, date, patientId, practitionerId) {
        String.prototype.replaceAll = function (s, r) { return this.split(s).join(r) };

        var url = "http://localhost:8082/EpilepsyServer/rest/FollowUpEncounter/create/" +
            "?patientId=" + patientId +
            "&date=" + "2016-05-31" +
            "&location=" + patientData.location +
            "&practitionerId=" + practitionerId +
            "&frequency=" + patientData.frequency +
            "&regularity=" + patientData.regularity +
            "&remarks=" + patientData.remarks +
            "&adverseEvents=" + patientData.adverseEvents +
            "&nextDate=" + date;
        url = url.replaceAll("<", "%3C");
        url = url.replaceAll(">", "%3E");
        url = url.replaceAll(" ", "%20");
        console.log(url);
        return $http.post(url);
    }
});