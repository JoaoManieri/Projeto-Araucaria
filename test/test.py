out = {"projects": [
    {
        "name": "TM 567",
        "id": 123,
        "parent": {
            "name": "dewdedw"
        },
    },
    {
        "name": "Gaia",
        "id": 142,
        "parent": {
            "name": "dewdedw"
        },
    }, {
        "name": "Thanos",
        "id": 543,
        "parent": {
            "name": "dewdedw"
        }
    }
]}

for projects in out['projects']:
    print(projects['name'])
