# What you need to run the project

* Glassfish Application server 4.0+
* PostgreSQL Server 9.2+
* PostgreSQL JDBC driver

# How to set up your environment

* Download and install Glassfish application server
* Download and copy JDBC driver into [GLASSFISH_root_dir]/glassfish/domains/domain1/lib/
* Download and install PostgreSQL Server
* add your_user to the DB 

example:
createuser.exe --createdb --username postgres --no-createrole --pwprompt [username]

try to login:
psql -U [username] -d weblibrarydb

exit:
\q

* Edit username and password in [project_directory]/master/config/weblibrary_datasource.xml
* copy [project directory]/master/config/weblibrary_datasource.xml into [GLASSFISH_root_dir]/glassfish/domains/domain1/config/

* start Glassfish with [GLASSFISH root dir]/glassfish/bin/startserv --debug=true
* activate datasource [GLASSFISH root dir]/glassfish/bin/asadmin --port 4848 add-resources [GLASSFISH_root_dir]/glassfish/domains/domain1/config/weblibrary_datasource.xml
* build master project and deploy web.war
* open it on https://127.0.0.1/[context_root_given_during_deploy]/index.xhtml
