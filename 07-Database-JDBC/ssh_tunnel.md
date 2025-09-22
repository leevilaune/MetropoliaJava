establish the tunnel
<br>
`ssh -L 3307:localhost:3306 suspi`
connect to db
<br>
`mariadb -h localhost -P 3307 -u nullremote -p --skip-ssl`