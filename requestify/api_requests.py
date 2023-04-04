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



    def get_projects(self):
        # Query para projeto especifico
        # url = self.__url + 'projects.json?easy_query_q=Stellantis'

        # Query para todos os projetos abertos
        # url = self.__url + 'projects.json?include=trackers&offset=25&limit=25'

        #
        url = self.__url + '/issues.json?project_id=452'

        headers = {'Content-Type': 'application/json'}
        r = requests.get(url, auth=(self.__user, self.__password), headers=headers).text
        print(r)
