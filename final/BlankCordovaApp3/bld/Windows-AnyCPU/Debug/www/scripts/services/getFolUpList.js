app4.service('getFolUpList', function ($http) {
    this.getDetails = function (patId) {
        return $http.get('http://localhost:8082/EpilepsyServer/rest/FollowUpEncounter/' + patId);
    };
});