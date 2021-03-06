package marquez.api.mappers;

import marquez.api.models.JobRunResponse;
import marquez.service.models.JobRun;
import marquez.service.models.JobRunState;

public class CoreJobRunToApiJobRunResponseMapper extends Mapper<JobRun, JobRunResponse> {
  @Override
  public JobRunResponse map(JobRun value) {
    return new JobRunResponse(
        value.getGuid(),
        value.getNominalStartTime() == null ? null : value.getNominalStartTime().toString(),
        value.getNominalEndTime() == null ? null : value.getNominalEndTime().toString(),
        value.getRunArgs(),
        JobRunState.State.fromInt(value.getCurrentState()).name());
  }
}
