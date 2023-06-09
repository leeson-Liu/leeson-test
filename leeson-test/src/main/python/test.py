from locust import HttpUser, TaskSet, task
import os
# 定义用户行为
class UserBehavior(TaskSet):

    @task
    def baidu_index(self):
        self.client.get("/")


class WebsiteUser(HttpUser):
    task_set = UserBehavior
    min_wait = 3000
    max_wait = 6000

if __name__ == "__main__":
    os.system("")
