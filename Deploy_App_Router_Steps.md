git clone https://github.com/ccjavadev/cc-bulletinboard-ads-spring-boot.git

Install node, npm

prepare the .npmrc file

npm install --save @sap/approuter

Check the node_modules folder has been generated successfully

cf cs postgresql v9.4-dev postgres-bulletinboard-ads-springboot

cf cs xsuaa application uaa-bulletinboard -c security/xs-security.json

cf s | grep uaa

cf cs application-logs lite applogs-bulletinboard

Update the user id in the manifest.yml

cf push

cf map-route approuter-i314100-springboot cfapps.eu10.hana.ondemand.com -n i314100trial-approuter-i314100-springboot


[Reference]
https://github.com/ccjavadev/cc-coursematerial/blob/master/Security/Exercise_22_DeployApplicationRouter.md
