app3.controller('viewCaseFormCtrl', ['$scope','Blob','FileSaver', '$rootScope','getCaseForm','$location', function ($scope, Blob, FileSaver, $rootScope, getCaseForm,$location) {
 
    $scope.pFactors = [{ name: 'Sleep' }, { name: 'Lack of sleep' }, { name: 'Emotional factors' },
        { name: 'Hunger' }, { name: 'Omission of anticonvulsants' }, { name: 'Hot water bath' },
        { name: 'Fever' }, { name: 'Others' }];

    $scope.fHistories = [{ name: 'Epilepsy' }, { name: 'Febrile convulsions' }, { name: 'Psychosis' },
        { name: 'Mental retardation' }, { name: 'Others' }];

    getCaseForm.getDetails($rootScope.patient.id)
       .then(function (res) {
           $scope.location = res.data.location;
           $scope.data = res.data.diagnosticReport;
           $scope.selection1 = $scope.data.precipitatingFactors;
           $scope.selection2 = $scope.data.familyHistory;
           if ($scope.data.hasOwnProperty('myoclonicEpilepsy')) {
               console.log("true");
               $scope.data.typesOfSeizures = "Myoclonic Epilepsy";
               $scope.data.subtypesOfSeizures = $scope.data.myoclonicEpilepsy;
           }
           if ($scope.data.hasOwnProperty('absence')) {
               $scope.data.typesOfSeizures = "Absence";
               $scope.data.subtypesOfSeizures = $scope.data.absence;
           }
           if ($scope.data.hasOwnProperty('partialSeizures')) {
               $scope.data.typesOfSeizures = "Partial Seizures";
               $scope.data.subtypesOfSeizures = $scope.data.partialSeizures;
           }
           if ($scope.data.hasOwnProperty('primaryGeneralisedEpilepsy')) {
               $scope.data.typesOfSeizures = "Primary Generalised Epilepsy";
               $scope.data.subtypesOfSeizures = $scope.data.primaryGeneralisedEpilepsy;
           }
           if ($scope.data.hasOwnProperty('secondaryGeneralisedSeizures')) {
               $scope.data.typesOfSeizures = "Secondary Generalized Seizures";
               $scope.data.subtypesOfSeizures = " ";
           }

       });

   /* $scope.downloadFile = function () {
        getCaseForm.getFile($rootScope.patient.id).success(function (data) {
            console.log("pop");
            var file = new Blob([data], { type: 'application/octet-stream' });
            //FileSaver.saveAs(file, $rootScope.patient.id);
            $scope.url = (window.URL || window.webkitURL).createObjectURL(file);
        }).error(function (data) {
            $window.alert("video not present");
       });
    };*/
   
   /* getCaseForm.getFile($rootScope.patient.id).success(function (data) {
        console.log("pop");
        var file = new Blob([data], { type: 'application/octet-stream' });
        //FileSaver.saveAs(file, $rootScope.patient.id);
        $scope.url = (window.URL || window.webkitURL).createObjectURL(file);
        window.open($scope.url);
        console.log($scope.url);
    });*/

    $scope.back = function () {
        $location.path('/patient/:id');
    };
}]);