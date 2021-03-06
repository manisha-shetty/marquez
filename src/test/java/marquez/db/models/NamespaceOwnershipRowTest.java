package marquez.db.models;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import org.junit.Test;

public class NamespaceOwnershipRowTest {
  private static final UUID ROW_UUID = UUID.randomUUID();
  private static final Instant STARTED_AT = Instant.now();
  private static final UUID NAMESPACE_UUID = UUID.randomUUID();
  private static final UUID OWNER_UUID = UUID.randomUUID();

  @Test
  public void testNewNamespaceOwnershipRow() {
    final Instant endedAt = Instant.now();
    final Optional<Instant> expectedEndedAt = Optional.of(endedAt);
    final NamespaceOwnershipRow namespaceOwnershipRow =
        NamespaceOwnershipRow.builder()
            .uuid(ROW_UUID)
            .startedAt(STARTED_AT)
            .endedAt(endedAt)
            .namespaceUuid(NAMESPACE_UUID)
            .ownerUuid(OWNER_UUID)
            .build();
    assertEquals(ROW_UUID, namespaceOwnershipRow.getUuid());
    assertEquals(STARTED_AT, namespaceOwnershipRow.getStartedAt());
    assertEquals(expectedEndedAt, namespaceOwnershipRow.getEndedAt());
    assertEquals(NAMESPACE_UUID, namespaceOwnershipRow.getNamespaceUuid());
    assertEquals(OWNER_UUID, namespaceOwnershipRow.getOwnerUuid());
  }

  @Test
  public void testNewNamespaceOwnershipRow_noEndedAt() {
    final Optional<Instant> noEndedAt = Optional.empty();
    final NamespaceOwnershipRow namespaceOwnershipRow =
        NamespaceOwnershipRow.builder()
            .uuid(ROW_UUID)
            .startedAt(STARTED_AT)
            .namespaceUuid(NAMESPACE_UUID)
            .ownerUuid(OWNER_UUID)
            .build();
    assertEquals(ROW_UUID, namespaceOwnershipRow.getUuid());
    assertEquals(STARTED_AT, namespaceOwnershipRow.getStartedAt());
    assertEquals(noEndedAt, namespaceOwnershipRow.getEndedAt());
    assertEquals(NAMESPACE_UUID, namespaceOwnershipRow.getNamespaceUuid());
    assertEquals(OWNER_UUID, namespaceOwnershipRow.getOwnerUuid());
  }

  @Test(expected = NullPointerException.class)
  public void testNewNamespaceOwnershipRow_nullUuid() {
    final UUID nullUuid = null;
    NamespaceOwnershipRow.builder()
        .uuid(nullUuid)
        .startedAt(STARTED_AT)
        .namespaceUuid(NAMESPACE_UUID)
        .ownerUuid(OWNER_UUID)
        .build();
  }

  @Test(expected = NullPointerException.class)
  public void testNewNamespaceOwnershipRow_nullStartedAt() {
    final Instant nullStartedAt = null;
    NamespaceOwnershipRow.builder()
        .uuid(ROW_UUID)
        .startedAt(nullStartedAt)
        .namespaceUuid(NAMESPACE_UUID)
        .ownerUuid(OWNER_UUID)
        .build();
  }

  @Test(expected = NullPointerException.class)
  public void testNewNamespaceOwnershipRow_nullNamespaceUuid() {
    final UUID nullNamespaceUuid = null;
    NamespaceOwnershipRow.builder()
        .uuid(ROW_UUID)
        .startedAt(STARTED_AT)
        .namespaceUuid(nullNamespaceUuid)
        .ownerUuid(OWNER_UUID)
        .build();
  }

  @Test(expected = NullPointerException.class)
  public void testNewNamespaceOwnershipRow_nullOwnerUuid() {
    final UUID nullOwnerUuid = null;
    NamespaceOwnershipRow.builder()
        .uuid(ROW_UUID)
        .startedAt(STARTED_AT)
        .namespaceUuid(NAMESPACE_UUID)
        .ownerUuid(nullOwnerUuid)
        .build();
  }
}
