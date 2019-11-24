<!DOCTYPE html>
<html lang="en" xmlns="http://java.sun.com/jsf/facelets">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <title>Test!</title>
    <link rel="stylesheet" href="resources/css/testPageStyles.css" type="text/css">
</head>

<body>
    <#include "header.ftl">

    <div class="home-container">
        <div class="home-list">
            <div class="home-list-header">
                <h1>Word</h1>
            </div>
            <form class="home-list-form">
                <div class="home-list-item-container">
                    <div class="home-list-item">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
                            <label class="form-check-label" for="exampleRadios1">
                                  Translation
                                </label>
                        </div>
                    </div>
                    <div class="home-list-item">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
                            <label class="form-check-label" for="exampleRadios1">
                                  Translation
                                </label>
                        </div>
                    </div>
                </div>
                <div class="home-list-item-container">
                    <div class="home-list-item">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
                            <label class="form-check-label" for="exampleRadios1">
                                      Translation
                                    </label>
                        </div>
                    </div>
                    <div class="home-list-item">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
                            <label class="form-check-label" for="exampleRadios1">
                                      Translation
                                    </label>
                        </div>
                    </div>
                </div>
                <div class="home-list-item-container">
                    <button type="button" class="btn btn-danger">Prev Question</button>
                    <button type="button" class="btn btn-success">Next Question</button>

                </div>
            </form>
        </div>
    </div>

    <#--<div class="home-footer">-->
        <#--<!-- Здесь Деля меняет содержимое футэра &ndash;&gt;-->
        <#--<div class="home-footer-item"><a class="home-footer-contacts" href="ContactsPage.html">Наши Контакты</a></div>-->
        <#--<div class="home-footer-item"><a class="home-footer-test" href="AboutPage.html">О нас</a></div>-->
        <#--<div class="home-footer-item">All copyrightes reserved</div>-->

    <#--</div>-->
    <#include "footer.ftl">

</body>

</html>