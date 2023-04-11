import datetime
import json

windows = []

initTime = 0


def add_element(process):
    windows.append(process)


def createreport():
    arquivo = open('data/tasks.json', 'r')
    conteudo = json.loads(arquivo.read())
    arquivo.close()

    task = conteudo['tasks']

    finisiTime = datetime.datetime.now()
    hora_atual = finisiTime.strftime("%H:%M:%S")

    dt = datetime.datetime.fromtimestamp(initTime)
    data_title = dt.strftime("%Y-%m-%d %H:%M:%S")
    hora_inicio = dt.strftime("%H:%M:%S")

    filename = f'out/report_{task}_{str(data_title)}.json'.replace(" ", "_").replace("-", "_").replace(":", "_")

    data = {
        "task": task,
        "hora_inicial": str(hora_inicio),
        "hora_final": str(hora_atual),
        "list": windows
    }

    arquivo = open(filename, 'w')
    arquivo.write(json.dumps(data))
    arquivo.close()

    filename = f'out/report_{task}_{str(data_title)}.txt'.replace(" ", "_").replace("-", "_").replace(":", "_")

    arquivo = open(filename, 'w')


    dt = datetime.datetime.fromtimestamp(initTime)

    arquivo.write(f"Tarefa: {task} \n")
    arquivo.write(f"Você trabalhou por um total de: {finisiTime - dt} \n")

    itens_iguais = set(windows)
    for item in itens_iguais:

        quantidade = windows.count(item)
        segundos_trabalhados = ((quantidade) * 1)

        horas = segundos_trabalhados // 3600
        segundos_restantes = segundos_trabalhados % 3600
        minutos = segundos_restantes // 60
        segundos_finais = segundos_restantes % 60

        fHoras = "{:02d}:{:02d}:{:02d}".format(horas, minutos, segundos_finais)

        arquivo.write(f"Você trabalhou em {item} por aproximadamente {fHoras} \n")

    arquivo.close()