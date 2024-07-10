```toml
name = 'update'
method = 'PUT'
url = 'http://localhost:8080/customer'
sortWeight = 2000000
id = 'ae626adb-c7c9-42dd-8b43-0f8c7f741f79'

[[headers]]
key = 'Content-Type'
value = 'application/json'

[body]
type = 'JSON'
raw = '''
{
  "id": 1,
  "name": "siti"
}'''
```
