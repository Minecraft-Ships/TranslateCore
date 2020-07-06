package org.core.configuration;

public class DefaultNode<D extends Object> extends ConfigurationNode {

    private D defaultValue;

    public DefaultNode(D value, ConfigurationNode node, String... path2) {
        super(node, path2);
    }

    public DefaultNode(D value, Object[] path1, Object... path2) {
        super(path1, path2);
    }

    public DefaultNode(D value, Object... path) {
        super(path);
    }

    public D getDefaultValue(){
        return this.defaultValue;
    }

}
