
from django.urls import path
from  .views import *
urlpatterns = [
    path('', index, name='index'),
    path('iniciarSesion', iniciarsesion, name='iniciarSesion'),   
    path('register', registrar, name="registrar"),
    path('instrumentosCuerdas',instr1, name="instrumentosCuerdas"),
    path('instrumentosPercusion',instr2, name="instrumentosPercusion"),
    path('amplificadores',instr3, name="amplificador"),
    path('accesorios',instr4, name="accesorio"),
]
