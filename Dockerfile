FROM lightjason/agentspeak

RUN apk --no-cache update &&\
    apk --no-cache upgrade &&\
    apk --no-cache add go musl-dev openssh-client

RUN go get -u github.com/tcnksm/ghr
RUN rm -rf /tmp/*
