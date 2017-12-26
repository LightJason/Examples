FROM lightjason/agentspeak

RUN apk --no-cache update &&\
    apk --no-cache upgrade &&\
    apk --no-cache add go musl-dev

RUN go get -u github.com/tcnksm/ghr
ENV PATH /root/go/bin:$PATH

RUN rm -rf /tmp/*
