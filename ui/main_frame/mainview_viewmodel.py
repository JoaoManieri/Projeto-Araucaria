import json

import requestify.api_requests as req


def getAllProjects():
    project_list = []

    projects = json.loads(req.ApiRequests().get_projects())

    for project in projects['issues']:
        print(project['subject'])
        name = project['subject']
        project_list.append(f'{name}')

    return project_list


def saveTasks(tasks):
    data = {
        "tasks": tasks
    }
    path = u'data/tasks.json'

    arquivo = open(path, 'w')
    arquivo.write(json.dumps(data))
    arquivo.close()


