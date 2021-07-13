package com.example.http.request;

import com.example.http.annotation.RequestMethod;
import com.example.http.parser.IParser;
import com.example.http.request.host.IHost;

import java.lang.reflect.Type;
import java.util.Map;

public class LfRequest implements IRequest{

    protected IHost host;
    @RequestMethod
    protected int requestMethod;
    protected String path;
    protected Type type;
    protected IParser resultParser;
    private Map<String, Object> mParams;

    @Override
    public void setParam(Map<String, Object> params) {
        this.mParams = params;
    }

    @Override
    public Map<String, Object> getParams() {
        return this.mParams;
    }

    @Override
    public int getRequestMethod() {
        return this.requestMethod;
    }

    @Override
    public IHost getHost() {
        return this.host;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public IParser getParser() {
        return resultParser;
    }

    @Override
    public Type getType() {
        return type;
    }
}
