import json

import requestify.api_requests as req
def getAllProjects():

    project_list = []

    projects = json.loads(req.ApiRequests().get_projects())

    for project in projects['projects']:
        print(project['name'])
        project_list.append(project['name'])

    return project_list
