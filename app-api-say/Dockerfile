FROM open-liberty:kernel-java8-openj9

LABEL com.sercheo.api.vendor="chancaysergio@gmail.com" \
      com.sercheo.api.maintainer="chancaysergio@gmail.com" \
      com.sercheo.api.description="API for expose dashboard on Grafana" \
      com.sercheo.api.version=1.0.0

ADD ./target/liberty/wlp/usr/servers /liberty/usr/servers
ADD ./target/liberty/wlp/usr/extension /liberty/usr/extension

USER root
RUN chmod 777 -R /liberty/usr/servers /liberty/usr/extension
RUN ln -s /opt/ol/wlp/usr/servers /servers

USER 1001

HEALTHCHECK --interval=5s --timeout=3s --retries=3 CMD curl --fail http://localhost:9080/health/live || exit 1

# Run the server script and start the defaultServer by default.
ENTRYPOINT ["/opt/ol/wlp/bin/server", "run"]
CMD ["defaultServer"]