// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CoastlineContainer.proto

package com.chunkmapper.protoc;

public final class CoastlineContainer {
  private CoastlineContainer() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  public interface CoastlineSectionOrBuilder
      extends com.google.protobuf.MessageLiteOrBuilder {

    // repeated .Point points = 1;
    /**
     * <code>repeated .Point points = 1;</code>
     */
    java.util.List<com.chunkmapper.protoc.PointContainer.Point> 
        getPointsList();
    /**
     * <code>repeated .Point points = 1;</code>
     */
    com.chunkmapper.protoc.PointContainer.Point getPoints(int index);
    /**
     * <code>repeated .Point points = 1;</code>
     */
    int getPointsCount();

    // required .Rectangle bbox = 2;
    /**
     * <code>required .Rectangle bbox = 2;</code>
     */
    boolean hasBbox();
    /**
     * <code>required .Rectangle bbox = 2;</code>
     */
    com.chunkmapper.protoc.RectangleContainer.Rectangle getBbox();
  }
  /**
   * Protobuf type {@code CoastlineSection}
   */
  public static final class CoastlineSection extends
      com.google.protobuf.GeneratedMessageLite
      implements CoastlineSectionOrBuilder {
    // Use CoastlineSection.newBuilder() to construct.
    private CoastlineSection(com.google.protobuf.GeneratedMessageLite.Builder builder) {
      super(builder);

    }
    private CoastlineSection(boolean noInit) {}

    private static final CoastlineSection defaultInstance;
    public static CoastlineSection getDefaultInstance() {
      return defaultInstance;
    }

    public CoastlineSection getDefaultInstanceForType() {
      return defaultInstance;
    }

    private CoastlineSection(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                points_ = new java.util.ArrayList<com.chunkmapper.protoc.PointContainer.Point>();
                mutable_bitField0_ |= 0x00000001;
              }
              points_.add(input.readMessage(com.chunkmapper.protoc.PointContainer.Point.PARSER, extensionRegistry));
              break;
            }
            case 18: {
              com.chunkmapper.protoc.RectangleContainer.Rectangle.Builder subBuilder = null;
              if (((bitField0_ & 0x00000001) == 0x00000001)) {
                subBuilder = bbox_.toBuilder();
              }
              bbox_ = input.readMessage(com.chunkmapper.protoc.RectangleContainer.Rectangle.PARSER, extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(bbox_);
                bbox_ = subBuilder.buildPartial();
              }
              bitField0_ |= 0x00000001;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
          points_ = java.util.Collections.unmodifiableList(points_);
        }
        makeExtensionsImmutable();
      }
    }
    public static com.google.protobuf.Parser<CoastlineSection> PARSER =
        new com.google.protobuf.AbstractParser<CoastlineSection>() {
      public CoastlineSection parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new CoastlineSection(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<CoastlineSection> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // repeated .Point points = 1;
    public static final int POINTS_FIELD_NUMBER = 1;
    private java.util.List<com.chunkmapper.protoc.PointContainer.Point> points_;
    /**
     * <code>repeated .Point points = 1;</code>
     */
    public java.util.List<com.chunkmapper.protoc.PointContainer.Point> getPointsList() {
      return points_;
    }
    /**
     * <code>repeated .Point points = 1;</code>
     */
    public java.util.List<? extends com.chunkmapper.protoc.PointContainer.PointOrBuilder> 
        getPointsOrBuilderList() {
      return points_;
    }
    /**
     * <code>repeated .Point points = 1;</code>
     */
    public int getPointsCount() {
      return points_.size();
    }
    /**
     * <code>repeated .Point points = 1;</code>
     */
    public com.chunkmapper.protoc.PointContainer.Point getPoints(int index) {
      return points_.get(index);
    }
    /**
     * <code>repeated .Point points = 1;</code>
     */
    public com.chunkmapper.protoc.PointContainer.PointOrBuilder getPointsOrBuilder(
        int index) {
      return points_.get(index);
    }

    // required .Rectangle bbox = 2;
    public static final int BBOX_FIELD_NUMBER = 2;
    private com.chunkmapper.protoc.RectangleContainer.Rectangle bbox_;
    /**
     * <code>required .Rectangle bbox = 2;</code>
     */
    public boolean hasBbox() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required .Rectangle bbox = 2;</code>
     */
    public com.chunkmapper.protoc.RectangleContainer.Rectangle getBbox() {
      return bbox_;
    }

    private void initFields() {
      points_ = java.util.Collections.emptyList();
      bbox_ = com.chunkmapper.protoc.RectangleContainer.Rectangle.getDefaultInstance();
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasBbox()) {
        memoizedIsInitialized = 0;
        return false;
      }
      for (int i = 0; i < getPointsCount(); i++) {
        if (!getPoints(i).isInitialized()) {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      if (!getBbox().isInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      for (int i = 0; i < points_.size(); i++) {
        output.writeMessage(1, points_.get(i));
      }
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeMessage(2, bbox_);
      }
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < points_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, points_.get(i));
      }
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, bbox_);
      }
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineSection parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineSection parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineSection parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineSection parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineSection parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineSection parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineSection parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineSection parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineSection parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineSection parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.chunkmapper.protoc.CoastlineContainer.CoastlineSection prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    /**
     * Protobuf type {@code CoastlineSection}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
          com.chunkmapper.protoc.CoastlineContainer.CoastlineSection, Builder>
        implements com.chunkmapper.protoc.CoastlineContainer.CoastlineSectionOrBuilder {
      // Construct using com.chunkmapper.protoc.CoastlineContainer.CoastlineSection.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        points_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        bbox_ = com.chunkmapper.protoc.RectangleContainer.Rectangle.getDefaultInstance();
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.chunkmapper.protoc.CoastlineContainer.CoastlineSection getDefaultInstanceForType() {
        return com.chunkmapper.protoc.CoastlineContainer.CoastlineSection.getDefaultInstance();
      }

      public com.chunkmapper.protoc.CoastlineContainer.CoastlineSection build() {
        com.chunkmapper.protoc.CoastlineContainer.CoastlineSection result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.chunkmapper.protoc.CoastlineContainer.CoastlineSection buildPartial() {
        com.chunkmapper.protoc.CoastlineContainer.CoastlineSection result = new com.chunkmapper.protoc.CoastlineContainer.CoastlineSection(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          points_ = java.util.Collections.unmodifiableList(points_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.points_ = points_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000001;
        }
        result.bbox_ = bbox_;
        result.bitField0_ = to_bitField0_;
        return result;
      }

      public Builder mergeFrom(com.chunkmapper.protoc.CoastlineContainer.CoastlineSection other) {
        if (other == com.chunkmapper.protoc.CoastlineContainer.CoastlineSection.getDefaultInstance()) return this;
        if (!other.points_.isEmpty()) {
          if (points_.isEmpty()) {
            points_ = other.points_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensurePointsIsMutable();
            points_.addAll(other.points_);
          }
          
        }
        if (other.hasBbox()) {
          mergeBbox(other.getBbox());
        }
        return this;
      }

      public final boolean isInitialized() {
        if (!hasBbox()) {
          
          return false;
        }
        for (int i = 0; i < getPointsCount(); i++) {
          if (!getPoints(i).isInitialized()) {
            
            return false;
          }
        }
        if (!getBbox().isInitialized()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.chunkmapper.protoc.CoastlineContainer.CoastlineSection parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.chunkmapper.protoc.CoastlineContainer.CoastlineSection) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // repeated .Point points = 1;
      private java.util.List<com.chunkmapper.protoc.PointContainer.Point> points_ =
        java.util.Collections.emptyList();
      private void ensurePointsIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          points_ = new java.util.ArrayList<com.chunkmapper.protoc.PointContainer.Point>(points_);
          bitField0_ |= 0x00000001;
         }
      }

      /**
       * <code>repeated .Point points = 1;</code>
       */
      public java.util.List<com.chunkmapper.protoc.PointContainer.Point> getPointsList() {
        return java.util.Collections.unmodifiableList(points_);
      }
      /**
       * <code>repeated .Point points = 1;</code>
       */
      public int getPointsCount() {
        return points_.size();
      }
      /**
       * <code>repeated .Point points = 1;</code>
       */
      public com.chunkmapper.protoc.PointContainer.Point getPoints(int index) {
        return points_.get(index);
      }
      /**
       * <code>repeated .Point points = 1;</code>
       */
      public Builder setPoints(
          int index, com.chunkmapper.protoc.PointContainer.Point value) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePointsIsMutable();
        points_.set(index, value);

        return this;
      }
      /**
       * <code>repeated .Point points = 1;</code>
       */
      public Builder setPoints(
          int index, com.chunkmapper.protoc.PointContainer.Point.Builder builderForValue) {
        ensurePointsIsMutable();
        points_.set(index, builderForValue.build());

        return this;
      }
      /**
       * <code>repeated .Point points = 1;</code>
       */
      public Builder addPoints(com.chunkmapper.protoc.PointContainer.Point value) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePointsIsMutable();
        points_.add(value);

        return this;
      }
      /**
       * <code>repeated .Point points = 1;</code>
       */
      public Builder addPoints(
          int index, com.chunkmapper.protoc.PointContainer.Point value) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePointsIsMutable();
        points_.add(index, value);

        return this;
      }
      /**
       * <code>repeated .Point points = 1;</code>
       */
      public Builder addPoints(
          com.chunkmapper.protoc.PointContainer.Point.Builder builderForValue) {
        ensurePointsIsMutable();
        points_.add(builderForValue.build());

        return this;
      }
      /**
       * <code>repeated .Point points = 1;</code>
       */
      public Builder addPoints(
          int index, com.chunkmapper.protoc.PointContainer.Point.Builder builderForValue) {
        ensurePointsIsMutable();
        points_.add(index, builderForValue.build());

        return this;
      }
      /**
       * <code>repeated .Point points = 1;</code>
       */
      public Builder addAllPoints(
          java.lang.Iterable<? extends com.chunkmapper.protoc.PointContainer.Point> values) {
        ensurePointsIsMutable();
        super.addAll(values, points_);

        return this;
      }
      /**
       * <code>repeated .Point points = 1;</code>
       */
      public Builder clearPoints() {
        points_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);

        return this;
      }
      /**
       * <code>repeated .Point points = 1;</code>
       */
      public Builder removePoints(int index) {
        ensurePointsIsMutable();
        points_.remove(index);

        return this;
      }

      // required .Rectangle bbox = 2;
      private com.chunkmapper.protoc.RectangleContainer.Rectangle bbox_ = com.chunkmapper.protoc.RectangleContainer.Rectangle.getDefaultInstance();
      /**
       * <code>required .Rectangle bbox = 2;</code>
       */
      public boolean hasBbox() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required .Rectangle bbox = 2;</code>
       */
      public com.chunkmapper.protoc.RectangleContainer.Rectangle getBbox() {
        return bbox_;
      }
      /**
       * <code>required .Rectangle bbox = 2;</code>
       */
      public Builder setBbox(com.chunkmapper.protoc.RectangleContainer.Rectangle value) {
        if (value == null) {
          throw new NullPointerException();
        }
        bbox_ = value;

        bitField0_ |= 0x00000002;
        return this;
      }
      /**
       * <code>required .Rectangle bbox = 2;</code>
       */
      public Builder setBbox(
          com.chunkmapper.protoc.RectangleContainer.Rectangle.Builder builderForValue) {
        bbox_ = builderForValue.build();

        bitField0_ |= 0x00000002;
        return this;
      }
      /**
       * <code>required .Rectangle bbox = 2;</code>
       */
      public Builder mergeBbox(com.chunkmapper.protoc.RectangleContainer.Rectangle value) {
        if (((bitField0_ & 0x00000002) == 0x00000002) &&
            bbox_ != com.chunkmapper.protoc.RectangleContainer.Rectangle.getDefaultInstance()) {
          bbox_ =
            com.chunkmapper.protoc.RectangleContainer.Rectangle.newBuilder(bbox_).mergeFrom(value).buildPartial();
        } else {
          bbox_ = value;
        }

        bitField0_ |= 0x00000002;
        return this;
      }
      /**
       * <code>required .Rectangle bbox = 2;</code>
       */
      public Builder clearBbox() {
        bbox_ = com.chunkmapper.protoc.RectangleContainer.Rectangle.getDefaultInstance();

        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      // @@protoc_insertion_point(builder_scope:CoastlineSection)
    }

    static {
      defaultInstance = new CoastlineSection(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:CoastlineSection)
  }

  public interface CoastlineRegionOrBuilder
      extends com.google.protobuf.MessageLiteOrBuilder {

    // repeated .CoastlineSection river_sections = 1;
    /**
     * <code>repeated .CoastlineSection river_sections = 1;</code>
     */
    java.util.List<com.chunkmapper.protoc.CoastlineContainer.CoastlineSection> 
        getRiverSectionsList();
    /**
     * <code>repeated .CoastlineSection river_sections = 1;</code>
     */
    com.chunkmapper.protoc.CoastlineContainer.CoastlineSection getRiverSections(int index);
    /**
     * <code>repeated .CoastlineSection river_sections = 1;</code>
     */
    int getRiverSectionsCount();
  }
  /**
   * Protobuf type {@code CoastlineRegion}
   */
  public static final class CoastlineRegion extends
      com.google.protobuf.GeneratedMessageLite
      implements CoastlineRegionOrBuilder {
    // Use CoastlineRegion.newBuilder() to construct.
    private CoastlineRegion(com.google.protobuf.GeneratedMessageLite.Builder builder) {
      super(builder);

    }
    private CoastlineRegion(boolean noInit) {}

    private static final CoastlineRegion defaultInstance;
    public static CoastlineRegion getDefaultInstance() {
      return defaultInstance;
    }

    public CoastlineRegion getDefaultInstanceForType() {
      return defaultInstance;
    }

    private CoastlineRegion(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                riverSections_ = new java.util.ArrayList<com.chunkmapper.protoc.CoastlineContainer.CoastlineSection>();
                mutable_bitField0_ |= 0x00000001;
              }
              riverSections_.add(input.readMessage(com.chunkmapper.protoc.CoastlineContainer.CoastlineSection.PARSER, extensionRegistry));
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
          riverSections_ = java.util.Collections.unmodifiableList(riverSections_);
        }
        makeExtensionsImmutable();
      }
    }
    public static com.google.protobuf.Parser<CoastlineRegion> PARSER =
        new com.google.protobuf.AbstractParser<CoastlineRegion>() {
      public CoastlineRegion parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new CoastlineRegion(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<CoastlineRegion> getParserForType() {
      return PARSER;
    }

    // repeated .CoastlineSection river_sections = 1;
    public static final int RIVER_SECTIONS_FIELD_NUMBER = 1;
    private java.util.List<com.chunkmapper.protoc.CoastlineContainer.CoastlineSection> riverSections_;
    /**
     * <code>repeated .CoastlineSection river_sections = 1;</code>
     */
    public java.util.List<com.chunkmapper.protoc.CoastlineContainer.CoastlineSection> getRiverSectionsList() {
      return riverSections_;
    }
    /**
     * <code>repeated .CoastlineSection river_sections = 1;</code>
     */
    public java.util.List<? extends com.chunkmapper.protoc.CoastlineContainer.CoastlineSectionOrBuilder> 
        getRiverSectionsOrBuilderList() {
      return riverSections_;
    }
    /**
     * <code>repeated .CoastlineSection river_sections = 1;</code>
     */
    public int getRiverSectionsCount() {
      return riverSections_.size();
    }
    /**
     * <code>repeated .CoastlineSection river_sections = 1;</code>
     */
    public com.chunkmapper.protoc.CoastlineContainer.CoastlineSection getRiverSections(int index) {
      return riverSections_.get(index);
    }
    /**
     * <code>repeated .CoastlineSection river_sections = 1;</code>
     */
    public com.chunkmapper.protoc.CoastlineContainer.CoastlineSectionOrBuilder getRiverSectionsOrBuilder(
        int index) {
      return riverSections_.get(index);
    }

    private void initFields() {
      riverSections_ = java.util.Collections.emptyList();
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      for (int i = 0; i < getRiverSectionsCount(); i++) {
        if (!getRiverSections(i).isInitialized()) {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      for (int i = 0; i < riverSections_.size(); i++) {
        output.writeMessage(1, riverSections_.get(i));
      }
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < riverSections_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, riverSections_.get(i));
      }
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    /**
     * Protobuf type {@code CoastlineRegion}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
          com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion, Builder>
        implements com.chunkmapper.protoc.CoastlineContainer.CoastlineRegionOrBuilder {
      // Construct using com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        riverSections_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion getDefaultInstanceForType() {
        return com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion.getDefaultInstance();
      }

      public com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion build() {
        com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion buildPartial() {
        com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion result = new com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion(this);
        int from_bitField0_ = bitField0_;
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          riverSections_ = java.util.Collections.unmodifiableList(riverSections_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.riverSections_ = riverSections_;
        return result;
      }

      public Builder mergeFrom(com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion other) {
        if (other == com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion.getDefaultInstance()) return this;
        if (!other.riverSections_.isEmpty()) {
          if (riverSections_.isEmpty()) {
            riverSections_ = other.riverSections_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureRiverSectionsIsMutable();
            riverSections_.addAll(other.riverSections_);
          }
          
        }
        return this;
      }

      public final boolean isInitialized() {
        for (int i = 0; i < getRiverSectionsCount(); i++) {
          if (!getRiverSections(i).isInitialized()) {
            
            return false;
          }
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.chunkmapper.protoc.CoastlineContainer.CoastlineRegion) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // repeated .CoastlineSection river_sections = 1;
      private java.util.List<com.chunkmapper.protoc.CoastlineContainer.CoastlineSection> riverSections_ =
        java.util.Collections.emptyList();
      private void ensureRiverSectionsIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          riverSections_ = new java.util.ArrayList<com.chunkmapper.protoc.CoastlineContainer.CoastlineSection>(riverSections_);
          bitField0_ |= 0x00000001;
         }
      }

      /**
       * <code>repeated .CoastlineSection river_sections = 1;</code>
       */
      public java.util.List<com.chunkmapper.protoc.CoastlineContainer.CoastlineSection> getRiverSectionsList() {
        return java.util.Collections.unmodifiableList(riverSections_);
      }
      /**
       * <code>repeated .CoastlineSection river_sections = 1;</code>
       */
      public int getRiverSectionsCount() {
        return riverSections_.size();
      }
      /**
       * <code>repeated .CoastlineSection river_sections = 1;</code>
       */
      public com.chunkmapper.protoc.CoastlineContainer.CoastlineSection getRiverSections(int index) {
        return riverSections_.get(index);
      }
      /**
       * <code>repeated .CoastlineSection river_sections = 1;</code>
       */
      public Builder setRiverSections(
          int index, com.chunkmapper.protoc.CoastlineContainer.CoastlineSection value) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRiverSectionsIsMutable();
        riverSections_.set(index, value);

        return this;
      }
      /**
       * <code>repeated .CoastlineSection river_sections = 1;</code>
       */
      public Builder setRiverSections(
          int index, com.chunkmapper.protoc.CoastlineContainer.CoastlineSection.Builder builderForValue) {
        ensureRiverSectionsIsMutable();
        riverSections_.set(index, builderForValue.build());

        return this;
      }
      /**
       * <code>repeated .CoastlineSection river_sections = 1;</code>
       */
      public Builder addRiverSections(com.chunkmapper.protoc.CoastlineContainer.CoastlineSection value) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRiverSectionsIsMutable();
        riverSections_.add(value);

        return this;
      }
      /**
       * <code>repeated .CoastlineSection river_sections = 1;</code>
       */
      public Builder addRiverSections(
          int index, com.chunkmapper.protoc.CoastlineContainer.CoastlineSection value) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRiverSectionsIsMutable();
        riverSections_.add(index, value);

        return this;
      }
      /**
       * <code>repeated .CoastlineSection river_sections = 1;</code>
       */
      public Builder addRiverSections(
          com.chunkmapper.protoc.CoastlineContainer.CoastlineSection.Builder builderForValue) {
        ensureRiverSectionsIsMutable();
        riverSections_.add(builderForValue.build());

        return this;
      }
      /**
       * <code>repeated .CoastlineSection river_sections = 1;</code>
       */
      public Builder addRiverSections(
          int index, com.chunkmapper.protoc.CoastlineContainer.CoastlineSection.Builder builderForValue) {
        ensureRiverSectionsIsMutable();
        riverSections_.add(index, builderForValue.build());

        return this;
      }
      /**
       * <code>repeated .CoastlineSection river_sections = 1;</code>
       */
      public Builder addAllRiverSections(
          java.lang.Iterable<? extends com.chunkmapper.protoc.CoastlineContainer.CoastlineSection> values) {
        ensureRiverSectionsIsMutable();
        super.addAll(values, riverSections_);

        return this;
      }
      /**
       * <code>repeated .CoastlineSection river_sections = 1;</code>
       */
      public Builder clearRiverSections() {
        riverSections_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);

        return this;
      }
      /**
       * <code>repeated .CoastlineSection river_sections = 1;</code>
       */
      public Builder removeRiverSections(int index) {
        ensureRiverSectionsIsMutable();
        riverSections_.remove(index);

        return this;
      }

      // @@protoc_insertion_point(builder_scope:CoastlineRegion)
    }

    static {
      defaultInstance = new CoastlineRegion(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:CoastlineRegion)
  }


  static {
  }

  // @@protoc_insertion_point(outer_class_scope)
}
