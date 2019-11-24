<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="resources/css/profilePageStyles.css">
    <title>Profile</title>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script type="text/javascript" src="resources/js/profile.js"></script>
</head>

<body>
<#include "header.ftl">

    <div class="home-container">
        <div class="home-list">
            <div class="home-list-header">
                <h2>Профиль</h2>
            </div>
            <div class="home-list-container">
                <div class="home-list-container-table">
                    <div class="table table-borderless tg">
                        <table class="table">
                            <tr>
                                <th rowspan="4">
                                    <div class="profile-userpic-container">
                                        <img class="profile-userpic" src="resources/images/prime_words/avatar_square.png" alt="Grapefruit slice atop a pile of other slices"></th>
                                </div>
                                <th class="tg-0pky tg-text">Имя</th>
                                <td class="tg-0pky">${name}</td>
                            </tr>
                            <#--<tr>-->
                                <#--<th class="tg-0pky">Surname</th>-->
                                <#--<td class="tg-0pky">Goebbels</td>-->
                            <#--</tr>-->
                            <tr>
                                <th class="tg-0pky">Логин</th>
                                <td class="tg-0pky">${login}</td>
                            </tr>
                            <tr>
                                <th class="tg-0lax">Email</th>
                                <td class="tg-0lax">${mail}</td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="tg-align-center"> <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#accountModal">Change my data</button></td>
                                </div>

                            </tr>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>
<#--<#include "footer.ftl">-->
    <div class="modal fade" id="accountModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="m-content b-radius mf">
                <div class="modal-header mh">
                    <h3>Change your mind</h3>
                </div>
                <div class="modal-body">
                    <form class="needs-validation" id="accountEditForm" novalidate>
                        <label for="nameNew"> Name </label>
                        <input type="text" name="nameNew" placeholder="New Name..." class="form-control" required pattern="[A-Za-z]*" />
                        <div class="invalid-feedback">
                            Incorrect Name
                        </div>
                        <label for="lastnameNew" class="mt-3"> Surname </label>
                        <input type="text" name="lastnameNew" placeholder="New Surname..." class="form-control" required pattern="[A-Za-z]*" />
                        <div class="invalid-feedback">
                            Incorrect Surname
                        </div>>

                        <label class="mt-3">Your pic</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroupFileAddon01">Avatar</span>
                            </div>
                            <div class="custom-file">
                                <input type="file" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
                                <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-success">Save Changes</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
</body>

</html>