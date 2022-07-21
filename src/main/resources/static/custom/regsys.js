/*
$("#eventTable tr").click(function(id){
    window.location = "/event/"+id
}
*/

function redirectEvent(id){
    location.href = "/event/"+id;
}

function redirectPerson(id){
    location.href = "/person/"+id;
}

function redirectCompany(id){
    location.href = "/company/"+id;
}

function deleteEvent(id){
    location.href = "/event/" + id + "/delete";
}

function deletePerson(id){
    location.href = "/person/" + id + "/delete";
}

function deleteCompany(id){
    location.href = "/company/" + id + "/delete";
}

function showPersonForm(){
    document.getElementById('addPersonForm').style.display = 'block';
    document.getElementById('addCompanyForm').style.display = 'none';
}

function showCompanyForm(){
    document.getElementById('addPersonForm').style.display = 'none';
    document.getElementById('addCompanyForm').style.display = 'block';
}
