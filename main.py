from requestify.api_requests import ApiRequests
from windowmanager.active_window import ActiveWindow

api = ApiRequests()
api.get_projects()

# w = ActiveWindow()
# t = w.inti()
# t.start()