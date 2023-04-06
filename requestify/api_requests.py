import requests
from secrets.secrets import Secrets
import lxml.etree as etreei

"""
api doccumentation url: https://easyredmine.docs.apiary.io/#
"""


class ApiRequests:

    def __init__(self):
        secrets = Secrets()

        self.__url = secrets.url
        self.__password = secrets.password
        self.__user = secrets.username

    def login(self, username, password):
        url = self.__url + 'projects.json?include=trackers&offset=25&limit=25'
        headers = {'Content-Type': 'application/json'}
        r = requests.get(url, auth=(username, password), headers=headers).text
        if r.__sizeof__() > 100:
            return True
        else:
            return False

    def get_projects(self):
        # Query para projeto especifico
        # url = self.__url + 'projects.json?easy_query_q=Stellantis'

        # Query para todos os projetos abertos
        # url = self.__url + 'projects.json?include=trackers&offset=100&limit=100'

        # Query para projeto pelo nome
        # url = self.__url + 'projects.json?name=Diesel%20-%20Projeto%20Gaia'

        # Tarefas do projeto
        #url = self.__url + 'issues.json?project_id=605'

        # Info sobre o usuario
        # url = self.__url + 'users/'

        # Tarefas para determinado ID
        url = self.__url + 'issues.json?assigned_to_id=me&status_id=3'

        # Ids de status
        # 1 - Novo

        # 3 - Em andamento
        # 4 - Resolvido
        # 5 - Comentado
        # 6 - Finalizado
        # 7 - Rejeitado
        # 9 - Bloqueado

        headers = {'Content-Type': 'application/json'}
        return requests.get(url, auth=(self.__user, self.__password), headers=headers).text

print(ApiRequests().get_projects())