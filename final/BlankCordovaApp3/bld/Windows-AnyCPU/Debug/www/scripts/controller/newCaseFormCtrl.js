app3.controller('newCaseFormCtrl', ['$scope','$rootScope','createCaseForm', '$location', function ($scope,$rootScope,createCaseForm,$location ) {
    $scope.onsetAges = [{ name: '< 6 months' }, { name: '6 months 1 year' }, { name: '1-5 years' }, { name: '5-10 years' },
       { name: '10-15 years' }, { name: '15-20 years' }, { name: '20-30 years' }, { name: '30-40 years' }, { name: 'above 40 years' }];

    $scope.seizureTypes = [
        {
            name: 'Absence',
            sub: [{ name: 'Simple Absence' }, { name: 'Complex Absence' }, { name: 'Atonic absence' }, { name: 'Myoclonic absence' }, { name: 'Others' }]
        },
        {
            name: 'Myoclonic Epilepsy',
            sub: [{ name: "West's Syndrome" }, { name: "Lennox-Gastuat Syndrome" }, { name: "Myoclonic Epilepsy of childhood/adolesence" },
            { name: "Photosensitive myoclonus" }, { name: "Others" }]
        },
        {
            name: 'Primary Generalised Epilepsy',
            sub: [{ name: 'Tonic-clonic epilepsy' }, { name: 'Tonic Epilepsy' }, { name: 'Clonic Epilepsy' }, { name: 'Febrile convulsions' }]
        },
        {
            name: 'Partial Seizures',
            sub: [{ name: 'Simple Partial Seizures' }, { name: 'Complex Partial Seizures' }]
        },
        {
            name: 'Secondary Generalized Seizures',
            sub: [{ name: "" }]
        }
    ];
    $scope.seizureDurations = [{ name: '< 1 month' }, { name: '1-2 months' }, { name: '2-3 months' }, { name: '3-6 months' },
        { name: '6-12 months' }, { name: '1-2 years' }, { name: '2-5 years' }, { name: '5 years and above' }];

    $scope.beforeFrequencies = [{ name: 'Many times a day' }, { name: 'Once a day' }, { name: 'Once in 2-7 days' },
        { name: 'Once in 15-30 days' }, { name: '1-3 months' }, { name: '3-6 months' }, { name: '6-12 months' }];

    $scope.afterFrequencies = [{ name: 'Many times a day' }, { name: 'Once a day' }, { name: 'Once in 2-7 days' },
        { name: 'Once in 8-15 days' }, { name: 'Once in 15-30 days' }, { name: '1-3 months' },
        { name: '3-6 months' }, { name: '6-12 months' }, { name: '1-2 years' }, { name: 'Not applicable' }];

    $scope.attacks = [{ name: 'Absent' }, { name: 'Present' }, { name: 'Not Applicable' }];

    $scope.epilepticus = [{ name: 'Absent' }, { name: 'Present' }, { name: 'Not Applicable' }];

    $scope.pFactors = [{ name: 'Sleep' }, { name: 'Lack of sleep' }, { name: 'Emotional factors' },
        { name: 'Hunger' }, { name: 'Omission of anticonvulsants' }, { name: 'Hot water bath' },
        { name: 'Fever' }, { name: 'Others' }];

    $scope.selection1 = [];

    $scope.select1 = function select1(type) {
        var index = $scope.selection1.indexOf(type);
        if (index > -1) { $scope.selection1.splice(index, 1); }
        else { $scope.selection1.push(type); }
    };

    $scope.pHistories = [{ name: 'None significant' }, { name: 'Febrile convulsions' }, { name: 'Head injury' },
        { name: 'CNS infections' }, { name: 'Birth trauma' }, { name: 'Not applicable' }];

    $scope.fHistories = [{ name: 'Epilepsy' }, { name: 'Febrile convulsions' }, { name: 'Psychosis' },
        { name: 'Mental retardation' }, { name: 'Others' }];

    $scope.selection2 = [];
    $scope.select2 = function select2(type) {
        var index = $scope.selection2.indexOf(type);

        if (index > -1) { $scope.selection2.splice(index, 1); }
        else { $scope.selection2.push(type);  }
    };

    $scope.aeteologicalFactors = [{ name: 'Essential/Idiopathic' }, { name: 'Perinatal birth damage' }, { name: 'Traumatic birth injury' }, { name: 'Inflammatory' },
        { name: 'Metabolic' }, { name: 'Vascular' }, { name: 'Brain tumour' }, { name: 'Degenerative/Atrophic' }, { name: 'Others' }];

    $scope.pmstatus = [{ name: 'Normal' }, { name: 'Mental retardation' }, { name: 'Psychosis' }, { name: 'Neurosis' },
        { name: 'Behavioral problem' }, { name: 'Irritability' }, { name: 'Deterioration of memory' }, { name: 'M R + Behaviour problem' },
        { name: 'M R + Psychosis' }, { name: 'Others' }];

    $scope.ptreatments = [{ name: 'Treated' }, { name: 'Not treated' }, { name: 'Not known' }, { name: 'Not applicable' }];

    $scope.intelligence = [{ name: 'Normal' }, { name: 'Mild subnormality' }, { name: 'Moderate subnormality' }, { name: 'Severe subnormality' }, { name: 'Not applicable' }];

    $scope.examination = [{ name: 'Normal' }, { name: 'Abnormal' }, { name: 'Not done/Not possible' }];

    $scope.submitForm = function (data) {
        console.log(data.focBeforeTreatment + "1");
        createCaseForm.create(data, $scope.selection1, $scope.selection2,$rootScope.CurrentPatientId,$scope.currentUser.id).then(function successCallback(res) {
            console.log(res.status);
            $rootScope.patient.isCaseFormFilled = true;
            $location.path("/patient/:id");
        });

        if ($scope.myFile !== null)
        { createCaseForm.uploadFileToUrl($scope.myFile, $rootScope.CurrentPatientId); }
    }
}]);