from flask import Flask

from .app import app
from .models import model
# Connect sqlalchemy to app
model.db.init_app(app)
